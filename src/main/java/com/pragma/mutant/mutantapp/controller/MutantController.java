package com.pragma.mutant.mutantapp.controller;


import com.pragma.mutant.mutantapp.logger.ILoggerStrategy;
import com.pragma.mutant.mutantapp.model.request.DnaRequestDTO;
import com.pragma.mutant.mutantapp.model.response.StatsResponseDTO;
import com.pragma.mutant.mutantapp.service.IMutantService;
import com.pragma.mutant.mutantapp.util.Constants;
import com.pragma.mutant.mutantapp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(Constants.PATH_CONTROLLER)
public class MutantController {

    private final ILoggerStrategy logStrategy;

    private final IMutantService mutantService;

    @Autowired
    public MutantController(ILoggerStrategy logStrategy, IMutantService mutantService) {
        this.logStrategy = logStrategy;
        this.mutantService = mutantService;
    }


    /**
     * Validates and adds a new DNA sequence into the system
     *
     * @param request the request containing the DNA sequence
     * @return 200OK status if the given DNA belongs to a mutant, 403Forbidden otherwise
     */
    @PostMapping(value = Constants.PATH_VALIDATE_MUTANT)
    public ResponseEntity validateDna(@RequestBody DnaRequestDTO request) {
        logStrategy.logInfo("execute validate mutant");
        return mutantService.validateDNA(request) ? ResponseUtil.isMutantResponse() : ResponseUtil.isNotMutant();
    }


    /**
     * Retrieve the stats of all DNA sequences in the system
     *
     * @return a {@link StatsResponseDTO} within a Response Entity containing the stats of all persisted DNA sequences
     */
    @GetMapping(value = Constants.PATH_GET_STATS)
    public ResponseEntity<StatsResponseDTO> getDnaStats() {
        logStrategy.logInfo("execute get stats");
        return ResponseUtil.statsResponse(mutantService.getMutantStats());


    }
}
