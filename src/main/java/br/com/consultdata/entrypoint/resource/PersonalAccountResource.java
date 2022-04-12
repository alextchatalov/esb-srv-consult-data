package br.com.consultdata.entrypoint.resource;

import br.com.consultdata.core.model.BestServiceBundlePersonalAccount;
import br.com.consultdata.core.usecase.FindBestServiceBundleFromPersonalAccountUserCase;
import br.com.consultdata.entrypoint.mapper.BestServiceBundleFromPersonalAccountToBestServiceBundleFromPersonalAccountResponseMapper;
import br.com.consultdata.entrypoint.response.BestServiceBundleFromPersonalAccountResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/personal-accounts")
@RequiredArgsConstructor
@Slf4j
public class PersonalAccountResource {

    private final FindBestServiceBundleFromPersonalAccountUserCase findBestServiceBundleFromPersonalAccountUserCase;

    @GetMapping("/best/service-bundle")
    public ResponseEntity<List<BestServiceBundleFromPersonalAccountResponse>> getBestServiceBundleFromPersonalAccount(@RequestParam("type") final String type) {

        final List<BestServiceBundlePersonalAccount> bestServiceBundlePersonalAccounts = findBestServiceBundleFromPersonalAccountUserCase.execute(type);
        final List<BestServiceBundleFromPersonalAccountResponse> result = bestServiceBundlePersonalAccounts.stream().map(BestServiceBundleFromPersonalAccountToBestServiceBundleFromPersonalAccountResponseMapper::convert).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
