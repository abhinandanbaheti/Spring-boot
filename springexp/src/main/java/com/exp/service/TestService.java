package com.exp.service;
import com.exp.service.dtos.TestDTO;
import java.util.Collection;

public interface TestService {
    public abstract void createResource(TestDTO product);
    public abstract void updateResource(String id, TestDTO product);
    public abstract void deleteResource(String id);
    public abstract Collection<TestDTO> getResources();
}
