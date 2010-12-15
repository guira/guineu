 /*
 * Copyright 2007-2010 VTT Biotechnology
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
package guineu.modules.mylly.filter.ConcentrationsFromMass;

import guineu.data.Parameter;
import guineu.data.ParameterType;
import guineu.data.impl.SimpleParameter;
import guineu.data.impl.SimpleParameterSet;

/**
 *
 * @author scsandra
 */
public class ConcentrationsFromMassParameters extends SimpleParameterSet {

    public static final Parameter fileNames = new SimpleParameter(
            ParameterType.FILE_NAME, "File Name: ",
            "Name of the File", null, "Name of the File", null);
    public static final Parameter direction = new SimpleParameter(
            ParameterType.BOOLEAN, "TIC to EIC",
            "Oposite direction", new Boolean(false));
    public static final Parameter spectrumPeak = new SimpleParameter(
            ParameterType.DOUBLE, "Peak from Spectrum",
            "Peak from Spectrum", null, new Double(0.00),
             new Double(0.0), null, null);

    public ConcentrationsFromMassParameters() {
        super(new Parameter[]{fileNames, direction, spectrumPeak});
    }
}