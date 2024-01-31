package com.vemser.tests.basico.desafio;

import java.util.List;

public class Courses {
    private List<WebAutomation> webAutomation;
    private List<Api> api;
    private List<Mobile> mobile;

    public List<WebAutomation> getWebautomation() {
        return webAutomation;
    }

    public void setWebautomation(List<WebAutomation> webautomation) {
        this.webAutomation = webautomation;
    }

    public List<Api> getApi() {
        return api;
    }

    public void setApi(List<Api> api) {
        this.api = api;
    }

    public List<Mobile> getMobile() {
        return mobile;
    }

    public void setMobile(List<Mobile> mobile) {
        this.mobile = mobile;
    }
}
