package com.github.notyy.principle.srp;

import java.util.Set;

public class CellChecker {
    public void check(){
        Set<String> diffCells = findDiff();
        generateAutofixMMLs(diffCells);
    }

    private void generateAutofixMMLs(Set<String> diffCells) {
        for(String diff: diffCells){
            writeln(diff);
        }
        //close output channel
    }

    private void writeln(String diff) {

    }

    private Set<String> findDiff() {
        return null;
    }
}
