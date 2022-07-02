package Login.Page.Service;

import Login.Page.Entity.LoginPage;
import Login.Page.Repository.CreateAccountRepo;

public class addAccountImpl implements addAccount{
    private CreateAccountRepo createAccountRepo;

    public addAccountImpl(CreateAccountRepo createAccountRepo) {
        this.createAccountRepo = createAccountRepo;
    }

    @Override
    public void addAcc(String username, String password, String email) {
        LoginPage createAccount = new LoginPage(username,password,email);
        createAccountRepo.add(createAccount);
    }
}
