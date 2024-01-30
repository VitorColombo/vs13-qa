package com.vemser.tests.desafio;
import java.util.List;

public class Courses {
    private List<Curso> webAutomation;
    private List<Curso> api;
    private List<Curso> mobile;

    public List<Curso> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<Curso> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<Curso> getApi() {
        return api;
    }

    public void setApi(List<Curso> api) {
        this.api = api;
    }

    public List<Curso> getMobile() {
        return mobile;
    }

    public void setMobile(List<Curso> mobile) {
        this.mobile = mobile;
    }

    public void addWebAutomation(Curso curso) {
        this.webAutomation.add(curso);
    }

    public void addApi(Curso curso) {
        this.api.add(curso);
    }

    public void addMobile(Curso curso) {
        this.mobile.add(curso);
    }

    public void removeWebAutomation(Curso curso) {
        this.webAutomation.remove(curso);
    }

    public void removeApi(Curso curso) {
        this.api.remove(curso);
    }

    public void removeMobile(Curso curso) {
        this.mobile.remove(curso);
    }

}