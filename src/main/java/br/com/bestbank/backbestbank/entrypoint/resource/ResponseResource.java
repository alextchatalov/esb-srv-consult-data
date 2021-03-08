package br.com.bestbank.backbestbank.entrypoint.resource;

import br.com.bestbank.backbestbank.core.GetAllBanksUseCase;
import br.com.bestbank.backbestbank.core.model.Category;
import br.com.bestbank.backbestbank.core.model.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class ResponseResource {

    private final GetAllBanksUseCase getAllBanksUseCase;

    @GetMapping("/perssonal-accounts")
    public List<Root> getPessonalAccounts() {
        return getAllBanksUseCase.execute(Category.PERSONAL_ACCOUNTS);
    }
}
