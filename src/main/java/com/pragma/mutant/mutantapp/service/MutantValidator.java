package com.pragma.mutant.mutantapp.service;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MutantValidator implements IMutantValidator {

    /**
     * Determines whether a dna sequence belongs to a mutant or human
     *
     * @param dna the DNA sequence of the individual
     * @return true if the DNA belongs to a mutant, and false if it belongs to a human
     */
    public boolean isMutant(String[] dna) {

        if (ArrayUtils.isEmpty(dna)) {
            return false;
        }
        Set<Character> allowedCharacters = new HashSet<>();
        allowedCharacters.add('C');
        allowedCharacters.add('A');
        allowedCharacters.add('T');
        allowedCharacters.add('G');

        int foundSequences = 0;
        for (int row = 0; row < dna.length; row++) {
            String currentRow = dna[row];
            for (int column = 0; column < currentRow.length(); column++) {
                if (!allowedCharacters.contains(dna[row].charAt(column)))
                    throw new IllegalArgumentException(String.format("Invalid character %s in the given DNA array", dna[row].charAt(column)));
                boolean foundMutagenicString = findMutagenicStringFromCharPosition(row, column, dna);
                foundSequences = foundMutagenicString ? foundSequences + 1 : foundSequences;
                if (foundSequences > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Given a String of the DNA array, search in all the possible directions for repeated characters in the DNA matrix.
     * The allowed directions are horizontal, vertical, diagonal-left, diagonal-right
     *
     * @param rowPos    the position of the first character to search for in the row
     * @param columnPos the position of the first character to search for in the column
     * @param dna       the original DNA sequence array
     * @return true if a sequence of four characters is found, false otherwise
     */
    private boolean findMutagenicStringFromCharPosition(int rowPos, int columnPos, String[] dna) {

        //horizontal(hacia derecha), vertical (hacia abajo), diagonal hacia abajo-izquierda, diagonal hacia abajo-derecha
        final int[] directionColumn = {1, 0, -1, 1};
        final int[] directionRow = {0, 1, 1, 1};

        int availableDirections = directionColumn.length;
        char target = dna[rowPos].charAt(columnPos);
        int occurrences = 0;

        DIRECTION:
        for (int i = 0; i < availableDirections; i++) {
            int row = rowPos;
            int column = columnPos;
            char foundChar = dna[row].charAt(column);

            for (int j = 0; j < 4; j++) {
                row += directionRow[i];
                column += directionColumn[i];
                if (foundChar == target) {
                    occurrences++;
                }
                if (occurrences == 4) {
                    break DIRECTION;
                }
                if (foundChar != target || (row >= dna.length || column >= dna[0].length() || column < 0 || row < 0)) {
                    occurrences = 0;
                    continue DIRECTION;
                }
                foundChar = dna[row].charAt(column);

            }
        }
        return occurrences == 4;
    }

}