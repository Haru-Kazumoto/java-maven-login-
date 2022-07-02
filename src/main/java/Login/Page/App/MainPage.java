package Login.Page.App;

import Login.Page.Repository.CreateAccountRepo;
import Login.Page.Repository.CreateAccountRepoImpl;
import Login.Page.Service.addAccountImpl;
import Login.Page.Util.DatabaseUtil;
import Login.Page.Service.addAccount;
import Login.Page.View.CreateAccountView;
import com.zaxxer.hikari.HikariDataSource;

public class MainPage {
    public static void main(String[] args) {
        HikariDataSource dataSource = DatabaseUtil.getDataSource();
        CreateAccountRepo createAccountRepo = new CreateAccountRepoImpl(dataSource);
        addAccount create = new addAccountImpl(createAccountRepo);
        CreateAccountView createAccountView = new CreateAccountView(create);

        createAccountView.Menu();
    }
}
