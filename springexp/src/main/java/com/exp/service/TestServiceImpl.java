package com.exp.service;

import com.exp.service.dtos.TestDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    private static Map<String, TestDTO> testRepo = new HashMap();

    static {
        TestDTO honey = new TestDTO();
        honey.setId("1");
        honey.setName("Honey");
        testRepo.put(honey.getId(), honey);

        TestDTO almond = new TestDTO();
        almond.setId("2");
        almond.setName("Almond");
        testRepo.put(almond.getId(), almond);
    }

    @Override
    public void createResource(TestDTO product) {
        testRepo.put(product.getId(), product);
    }

    @Override
    public void updateResource(String id, TestDTO product) {
        testRepo.remove(id);
        product.setId(id);
        testRepo.put(id, product);
    }

    @Override
    public void deleteResource(String id) {
        testRepo.remove(id);

    }

    @Override
    public Collection<TestDTO> getResources() {
        return testRepo.values();
    }
}
