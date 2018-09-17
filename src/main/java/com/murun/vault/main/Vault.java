package com.murun.vault.main;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.murun.vault.repository", "com.murun.vault.control", "com.murun.vault.service", "com.murun.vault.model"})
@EnableJpaRepositories("com.murun.vault.*")
@EntityScan({"com.murun.vault.*"})
public class Vault {

    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(Vault.class);
        sa.setLogStartupInfo(true);
        sa.setBannerMode(Banner.Mode.OFF);
        sa.run(args);
    }


}
