package account;

import exception.CredentialAuthenticationException;
import java.util.NoSuchElementException;

public record LoginAccount(Account account) {

    public void accessLogin(String username, String password) throws CredentialAuthenticationException {
        if (account.accountUsername == null | account.accountPassword == null) {
            throw new NoSuchElementException("Not account found.");
        }

        if (!(username.equals(account.accountUsername) && password.equals(account.accountPassword))) {
            throw new CredentialAuthenticationException("Username/password incorrect.");
        }
    }

    public void createLogin(String createUsername, String createPassword, String createName) throws CredentialAuthenticationException {
        if (account.accountUsername != null) {
            throw new CredentialAuthenticationException("There is already an account created in this system");
        }

        this.account.accountUsername = createUsername;
        this.account.accountPassword = createPassword;
        this.account.accountName = createName.toUpperCase();

    }
}
