package br.com.consultdata.entrypoint.resource;

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


    @GetMapping("/perssonal-accounts")
    public List<Bank> getPessonalAccounts() {


        return null;
    }
}
