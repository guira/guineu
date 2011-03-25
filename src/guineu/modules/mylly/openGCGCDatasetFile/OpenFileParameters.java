/*
 * Copyright 2007-2011 VTT Biotechnology
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
package guineu.modules.mylly.openGCGCDatasetFile;

import guineu.parameters.SimpleParameterSet;
import guineu.parameters.UserParameter;
import guineu.parameters.parametersType.FileNameParameter;
import guineu.parameters.parametersType.NumberParameter;
import java.text.NumberFormat;

public class OpenFileParameters extends SimpleParameterSet {

        public static final NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        public static final FileNameParameter fileName = new FileNameParameter(
                "File Name: ",
                "File Name");
        public static final NumberParameter numColumns = new NumberParameter(
                "Number of Columns for Parameters: ",
                "Number of columns before the columns corresponding to the samples", integerFormat, new Integer(10));

        public OpenFileParameters() {
                super(new UserParameter[]{fileName, numColumns});
        }
}
