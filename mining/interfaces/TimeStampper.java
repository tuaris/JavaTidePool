/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mining.interfaces;

import java.util.Date;

/**
 *
 * @author Danny
 */
public class TimeStampper {
    public static int getTime(){
        return new Date().hashCode();
    }
}
