package com.api.rest.dto;

import java.util.List;

public class PageDto {
    private long total;
    private List itens;

    public PageDto(long total, List itens) {
        this.total = total;
        this.itens = itens;
    }

    public long getTotal() {
        return total;
    }

    public List getItens() {
        return itens;
    }
}
