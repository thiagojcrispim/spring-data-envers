package com.example.springdataenvers.poc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Aspect
@Component
public class AuditingAspect {
    @Value("${audited.entities}")
    private String[] auditedEntities;
    private Set<String> auditedEntitiesSet;

    @PostConstruct
    public void init() {
        auditedEntitiesSet = new HashSet<>(Arrays.asList(auditedEntities));
    }

    @Around("execution(* com.example.myapp.repository.*.save(..))")
    public Object audit(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            Object entity = args[0];
            if (auditedEntitiesSet.contains(entity.getClass().getName())) {
                // Código para auditar a entidade vai aqui.
                // Por exemplo, você pode registrar a operação de salvamento no console:
                System.out.println("Salvando entidade auditada: " + entity);
            }
        }
        return joinPoint.proceed();
    }
}