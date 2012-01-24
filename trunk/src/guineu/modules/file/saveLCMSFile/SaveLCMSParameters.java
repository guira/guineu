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
package guineu.modules.file.saveLCMSFile;

import guineu.data.LCMSColumnName;
import guineu.parameters.UserParameter;
import guineu.parameters.parametersType.ComboParameter;
import guineu.parameters.parametersType.StringParameter;
import guineu.parameters.SimpleParameterSet;
import guineu.parameters.parametersType.FileNameParameter;
import guineu.parameters.parametersType.MultiChoiceParameter;

public class SaveLCMSParameters extends SimpleParameterSet {

        static String[] objects = {"Excel", "csv", "ExpressionData"};
        public static final FileNameParameter LCMSfilename = new FileNameParameter(
                "GCGC Filename",
                "Name of exported peak list file name. If the file exists, it won't be overwritten.");
        public static final StringParameter fieldSeparator = new StringParameter(
                "Field separator",
                "Character(s) used to separate fields in the exported file",
                ",");
        public static final MultiChoiceParameter<LCMSColumnName> exportLCMS = new MultiChoiceParameter<LCMSColumnName>(
                "Export GCGC elements",
                "Multiple selection of row's elements to export",LCMSColumnName.values());
        public static final ComboParameter<String> type = new ComboParameter<String>(
                "GCGC type",
                "Type of file", objects);

        public SaveLCMSParameters() {
                super(new UserParameter[]{LCMSfilename, type, exportLCMS});
        }
}
