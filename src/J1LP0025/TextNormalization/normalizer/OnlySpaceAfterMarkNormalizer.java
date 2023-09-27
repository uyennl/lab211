/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0025.TextNormalization.normalizer;

import J1LP0025.TextNormalization.INormalizable;
import java.util.StringTokenizer;

/**
 * only space before mark 
 * @author Uyen
 */
public class OnlySpaceAfterMarkNormalizer implements INormalizable{
    private String mark;

    public OnlySpaceAfterMarkNormalizer(String mark) {
        this.mark = mark;
    }

    @Override
    public String normalize(String source) {
        String normalized = new String();

        StringTokenizer tokenizer = new StringTokenizer(source, this.mark);

        while (tokenizer.hasMoreTokens()) {
            normalized += (tokenizer.nextToken().trim() + this.mark + " ");
        }

        return normalized.substring(0, normalized.length() - 2);
    }
    
    
}
