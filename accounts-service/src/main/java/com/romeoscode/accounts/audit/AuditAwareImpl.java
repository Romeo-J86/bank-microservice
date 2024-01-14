package com.romeoscode.accounts.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author romeo.jerenyama
 * @created 06/01/2024 - 17:16
 */
@Component
public class AuditAwareImpl implements AuditorAware<String> {
    /**
     * Returns the current auditor of the application.
     *
     * @return the current auditor.
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("ACCOUNTS_MS");
    }
}
