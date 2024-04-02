package Class;
import java.util.Scanner;
import java.util.UUID;
public class AccountBank {


        private String accountUUID;
        private String accountType;
        private Double amount;
        public AccountBank(){

        }
        public AccountBank(String accountUUID, String accountType) {
            this.accountUUID = accountUUID;
            this.accountType = accountType;
        }
        public void withdrawal(Double amountToWithdraw){
            if(amountToWithdraw>this.amount){
                System.out.println("Cannot withdraw, because you balance is lower than the amount you want to withdraw.");
            }else {
                this.amount = this.amount - amountToWithdraw;

            }
        }
        public void deposit(Double amountToDeposit){
            this.amount = (this.amount== null ? 0D: this.amount) +  amountToDeposit;
        }
        public void showBalance(){
            System.out.println(STR."Balance of account \{this.accountType}: \{this.amount}");
        }

        @Override
        public String toString() {
            return STR."Account{accountUUID='\{accountUUID}\{'\''}, accountType='\{accountType}\{'\''}, amount=\{amount}\{'}'}";
        }
    }


    


