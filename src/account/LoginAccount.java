package account;

import exception.CredentialAuthenticationException;
import java.util.NoSuchElementException;

public record LoginAccount(Account account) {

    public void accessLogin(String username, String password) throws CredentialAuthenticationException {
        if (!(username.equals(account.accountUsername) && password.equals(account.accountPassword))) {
            throw new CredentialAuthenticationException("Username/password incorrect.");
        }

        if (account.accountUsername.isEmpty() && account.accountPassword.isEmpty()) {
            throw new NoSuchElementException("Not account found.");
        }
    }

    public void createLogin(String createUsernamer, String createPassword) {
        this.account.accountUsername = createUsernamer;
        this.account.accountPassword = createPassword;
        this.account.accountName = createUsernamer.toUpperCase();
    }
}
