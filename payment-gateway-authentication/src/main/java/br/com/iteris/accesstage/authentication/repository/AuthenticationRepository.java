package br.com.iteris.accesstage.authentication.repository;

import org.springframework.stereotype.Repository;

import br.com.iteris.accesstage.model.authentication.AuthenticationInfo;
import br.com.iteris.accesstage.authentication.validation.ValidAuthentications;
import br.com.iteris.accesstage.model.ClientId;

/**
 * Essa classe expõe serviços de dados para as camadas superiores.
 */
@Repository
public class AuthenticationRepository {

    private ValidAuthentications validAuthentications = new ValidAuthentications();

    /**
     * Valida se o clientId recebido é válido.
     *
     * @param clientId
     *      Combinação de afiliação e token recebidos das camadas superiores.
     *
     * @return True caso dados para autenticação sejam válidos, false caso contrário.
     */
    public boolean isValid(ClientId clientId) {
        return validAuthentications.contains(clientId);
    }

    /**
     * Busca informações de autenticação com base no ClientId recebido.
     *
     * @param clientId
     *      Combinação de afiliação e token recebidos das camadas superiores.
     *
     * @return Dados de autenticação associados a um adquirente.
     */
    public AuthenticationInfo findByClientId(ClientId clientId) {
        return this.validAuthentications.find(clientId);
    }
}
