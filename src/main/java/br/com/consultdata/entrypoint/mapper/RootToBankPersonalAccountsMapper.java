package br.com.consultdata.entrypoint.mapper;


import br.com.consultdata.core.model.Root;
import br.com.consultdata.entrypoint.model.*;
import lombok.NonNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface RootToBankPersonalAccountsMapper {

    static List<Bank> convert(@NonNull List<Root> roots) {

        List<Bank> banks = new ArrayList<>();

        for (Root root : roots) {
            root.getData().getBrand().getCompanies().stream().forEach(company -> {

                List<PersonalAccount> personalAccountList = new ArrayList<>();
                company.getPersonalAccounts().stream().forEach( pc -> {

                    List<ServiceBundle> serviceBundles = new ArrayList<>();

                    pc.getServiceBundles().stream().forEach(serviceBundle -> {

                        List<Service> services = serviceBundle
                                .getServices()
                                .stream().map(service -> new Service(service.getCode(), service.getChargingTriggerInfo()))
                                .collect(Collectors.toList());

                        BigDecimal minimum;
                        BigDecimal maximum;
                        try {
                            minimum = new BigDecimal(serviceBundle.getMinimum().getValue());
                            maximum = new BigDecimal(serviceBundle.getMaximum().getValue());
                        } catch (NumberFormatException e) {
                            minimum = BigDecimal.ZERO;
                            maximum = BigDecimal.ZERO;
                        }
                        serviceBundles.add(ServiceBundle.builder()
                                .name(serviceBundle.getName())
                                .services(services)
                                .minimumValue(minimum)
                                .maximumValue(maximum)
                                .build());
                    });

                    PersonalAccount personalAccount = PersonalAccount.builder()
                            .type(PersonalAccountsType.valueOf(pc.getType()))
                            .serviceBundles(serviceBundles)
                            .transactionMethods(convertStringToTransactionMethods(pc.getTransactionMethods()))
                            .build();
                    personalAccountList.add(personalAccount);

                });
                Bank bank = Bank.builder()
                        .name(company.getName())
                        .personalAccounts(personalAccountList)
                        .build();
                banks.add(bank);
            });
        }
        return banks;
    }

    private static List<TransactionMethods> convertStringToTransactionMethods(List<String> transactionMethods) {
        if (transactionMethods == null || transactionMethods.isEmpty()) {
            return new ArrayList<>();
        }
        return transactionMethods.stream().map(t -> TransactionMethods.valueOf(t)).collect(Collectors.toList());
    }
}
