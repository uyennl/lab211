/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0025.TextNormalization.normalizer;

import J1LP0025.TextNormalization.INormalizable;

/**
 *Don't At The End Normalizer
 * @author Uyen
 */
public class DotAtTheEndNormalizer implements INormalizable{

    @Override
    public String normalize(String source) {
        char lastChar = source.charAt(source.length() - 1);
        
        if(lastChar == '.')
            return source;
        
        return source + ".";
    }
    
}
