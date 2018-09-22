package org.freifeld.extremebenchmark.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@ApplicationScoped
public class HttpClientProvider {

    private Client client;

    @PostConstruct
    private void init() {
        this.client = ClientBuilder.newClient();
    }

    @PreDestroy
    private void tearDown() {
        this.client.close();
    }

    @Produces
    public Client provider(InjectionPoint ip) {
        return this.client;
    }

}
