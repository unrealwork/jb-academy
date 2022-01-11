package blockchain;

import blockchain.events.RequiredZeroesData;

public class ValidationResult {
    private final RequiredZeroesData requiredZeroes;
    private final boolean isValid;

    private ValidationResult(RequiredZeroesData requiredZeroes, boolean isValid) {
        this.requiredZeroes = requiredZeroes;
        this.isValid = isValid;
    }

    public static ValidationResult create(RequiredZeroesData requiredZeroes, boolean isValid) {
        return new ValidationResult(requiredZeroes, isValid);
    }

    public RequiredZeroesData getRequiredZeroes() {
        return requiredZeroes;
    }

    public boolean isValid() {
        return isValid;
    }
}
