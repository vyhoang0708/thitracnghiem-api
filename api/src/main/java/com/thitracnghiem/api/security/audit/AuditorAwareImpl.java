package com.thitracnghiem.api.security.audit;

import com.thitracnghiem.api.security.jwt.CustomAuthUser;
import lombok.NonNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public @NonNull Optional<Long> getCurrentAuditor() {
        try {
            if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null) {
                CustomAuthUser customAuthUser = (CustomAuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                if (customAuthUser != null) {
                    return Optional.of(Long.valueOf(customAuthUser.getUserId()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.of(0L);
    }

}