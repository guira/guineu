/*
 * Copyright 2007-2012 VTT Biotechnology
 * This file is part of Guineu.
 *
 * Guineu is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * Guineu is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Guineu; if not, write to the Free Software Foundation, Inc., 51 Franklin St,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */
package guineu.modules.dataanalysis.twowayanova;

import guineu.main.GuineuCore;
import guineu.parameters.SimpleParameterSet;
import guineu.parameters.UserParameter;
import guineu.parameters.parametersType.ComboParameter;

/**
 *
 * @author scsandra
 */
public class TwoWayAnovaParameters extends SimpleParameterSet {

        private static String[] parameters = GuineuCore.getDesktop().getSelectedDataFiles()[0].getParametersName().toArray(new String[0]);
        public static final ComboParameter<String> groups = new ComboParameter<String>(
                "Select the phenotype",
                "The groups to perform anova test will be taken from the choosen parameter", parameters);

         public static final ComboParameter<String> timePoints = new ComboParameter<String>(
                "Select the time points",
                "The time points to perform anova test will be taken from the choosen parameter", parameters);

        public TwoWayAnovaParameters(String[] parameters) {
                super(new UserParameter[]{groups, timePoints});
                groups.setChoices(parameters);
        }
}
