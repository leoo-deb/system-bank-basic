package account;

import exception.CredentialAuthenticationException;
import java.util.NoSuchElementException;

public record LoginAccount(Account account) {

    public void accessLogin(String username, String password) throws CredentialAuthenticationException, NoSuchElementException {
        if (!(username.equals(account.accountUsername) && password.equals(account.accountPassword))) {
            throw new CredentialAuthenticationException("Username/password incorrect.");
        }

        if (account.accountUsername.isEmpty() && account.accountPassword.isEmpty()) {
            throw new NoSuchElementException("Not account found.");
        }
    }

    public void createLogin(String createUsername, String createPassword) {
        this.account.accountUsername = createUsername;
        this.account.accountPassword = createPassword;
        this.account.accountName = createUsername.toUpperCase();
    }
}
