package br.com.consultdata.entrypoint.resource;

import br.com.consultdata.core.GetAllBanksUseCase;
import br.com.consultdata.core.model.Category;
import br.com.consultdata.core.model.Root;
import br.com.consultdata.entrypoint.mapper.RootToBankPersonalAccountsMapper;
import br.com.consultdata.entrypoint.model.Bank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class ResponseResource {

    private final GetAllBanksUseCase getAllBanksUseCase;

    @GetMapping("/perssonal-accounts")
    public List<Bank> getPessonalAccounts() {

        List<Root> root = getAllBanksUseCase.execute(Category.PERSONAL_ACCOUNTS);
        List<Bank> banks = RootToBankPersonalAccountsMapper.convert(root);

        return banks;
    }
}
