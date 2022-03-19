package service;

import com.google.gson.JsonElement;
import repository.DepartamentoRepository;
import repository.ProgramadorRepository;

public class ProgramadorService {

    private ProgramadorRepository programadorRepository;

    public ProgramadorService(ProgramadorRepository programadorRepository) {
        this.programadorRepository = programadorRepository;
    }

    public static JsonElement getAllCategories() {
        return null;
    }

}
