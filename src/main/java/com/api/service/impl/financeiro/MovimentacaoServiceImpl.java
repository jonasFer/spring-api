package com.api.service.impl.financeiro;

import com.api.domain.model.financeiro.Movimentacao;
import com.api.domain.model.financeiro.TipoMovimentacao;
import com.api.domain.model.item.Produto;
import com.api.service.MovimentacaoService;
import com.api.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoServiceImpl extends BaseServiceImpl implements MovimentacaoService {

    public Movimentacao createMovimentacaoProduto(TipoMovimentacao tipoMovimentacao, List<Produto> produtos) {
        return null;
    }
}
