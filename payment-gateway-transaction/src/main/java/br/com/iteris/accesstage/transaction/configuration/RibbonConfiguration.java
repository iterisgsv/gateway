package br.com.iteris.accesstage.transaction.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

/**
 * Classe que contém as configurações do cliente Ribbon usado para conexão aos outros microserviços.
 *
 * @author iterisgsv
 */
public class RibbonConfiguration {

    private final IClientConfig ribbonClientConfig;

    @Autowired
    public RibbonConfiguration(IClientConfig ribbonClientConfig) {
        this.ribbonClientConfig = ribbonClientConfig;
    }

    @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new PingUrl();
    }

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new AvailabilityFilteringRule();
    }
}
