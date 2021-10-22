class Account {

  private volatile long balance = 0;

  public synchronized boolean withdraw(long amount) {
    if (balance >= amount) {
      this.balance -= amount;
      return true;
    }
    return false;
  }

  public synchronized void deposit(long amount) {
    // do something useful
    this.balance = balance + amount;
  }

  public long getBalance() {
    return balance;
  }
}
