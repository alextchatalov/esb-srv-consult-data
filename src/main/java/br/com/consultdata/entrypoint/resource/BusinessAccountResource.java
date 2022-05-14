package br.com.consultdata.entrypoint.resource;

import br.com.consultdata.core.model.BestServiceBundleBusinessAccount;
import br.com.consultdata.core.model.TypeAccount;
import br.com.consultdata.core.usecase.FindBestServiceBundleFromBusinessAccountUserCase;
import br.com.consultdata.entrypoint.mapper.BestServiceBundleFromBusinessAccountToBestServiceBundleFromBusinessAccountResponseMapper;
import br.com.consultdata.entrypoint.response.BestServiceBundleFromBusinessAccountResponse;
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
@RequestMapping("/api/v1/business-accounts")
@RequiredArgsConstructor
@Slf4j
public class BusinessAccountResource {

    private final FindBestServiceBundleFromBusinessAccountUserCase findBestServiceBundleFromBusinessAccountUserCase;

    @GetMapping("/best/service-bundle")
    public ResponseEntity<List<BestServiceBundleFromBusinessAccountResponse>> getBestServiceBundleFromBusinessAccount(@RequestParam("typeAccount") final TypeAccount type) {

        final List<BestServiceBundleBusinessAccount> bestServiceBundlePersonalAccounts = findBestServiceBundleFromBusinessAccountUserCase.execute(type);
        final List<BestServiceBundleFromBusinessAccountResponse> result = bestServiceBundlePersonalAccounts.stream().map(BestServiceBundleFromBusinessAccountToBestServiceBundleFromBusinessAccountResponseMapper::convert).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
