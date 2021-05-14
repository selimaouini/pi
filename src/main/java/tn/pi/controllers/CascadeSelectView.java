package tn.pi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;

@Named
@RequestScoped
public class CascadeSelectView {

    private String selectedOption;
    private String rtl;
    private String hideNoSelectOption;

    private String countryGroup;
    private List<SelectItem> countriesGroup;

   

    private String option;
    private List<String> options;

    private String longItemLabel;
    private String labeled;

   

    @PostConstruct
    public void init() {

        countriesGroup = new ArrayList<>();

        SelectItemGroup europeCountries = new SelectItemGroup("Europe Countries");
        europeCountries.setSelectItems(new SelectItem[]{
                new SelectItem("Germany", "Germany"),
                new SelectItem("Turkey", "Turkey"),
                new SelectItem("Spain", "Spain")
        });

        SelectItemGroup americaCountries = new SelectItemGroup("America Countries");
        americaCountries.setSelectItems(new SelectItem[]{
                new SelectItem("United States", "United States"),
                new SelectItem("Brazil", "Brazil"),
                new SelectItem("Mexico", "Mexico")
        });

        countriesGroup.add(europeCountries);
        countriesGroup.add(americaCountries);

      

        //options
        options = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            options.add("Option " + i);
        }
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public String getRtl() {
        return rtl;
    }

    public String getHideNoSelectOption() {
        return hideNoSelectOption;
    }

    public void setHideNoSelectOption(String hideNoSelectOption) {
        this.hideNoSelectOption = hideNoSelectOption;
    }

    public void setRtl(String rtl) {
        this.rtl = rtl;
    }

    public String getCountryGroup() {
        return countryGroup;
    }

    public void setCountryGroup(String countryGroup) {
        this.countryGroup = countryGroup;
    }

    public List<SelectItem> getCountriesGroup() {
        return countriesGroup;
    }

    public void setCountriesGroup(List<SelectItem> countriesGroup) {
        this.countriesGroup = countriesGroup;
    }

    

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getLongItemLabel() {
        return longItemLabel;
    }

    public void setLongItemLabel(String longItemLabel) {
        this.longItemLabel = longItemLabel;
    }

    public String getLabeled() {
        return labeled;
    }

    public void setLabeled(String labeled) {
        this.labeled = labeled;
    }

    
}