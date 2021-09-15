package com.org.postal.modal;

import java.util.List;

public class ResponseLocalityDTO {
	
    private int postalCode;
    private List<String> names;

    public ResponseLocalityDTO(int postalCode, List<String> names){
        this.postalCode = postalCode;
        this.names = names;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

}
