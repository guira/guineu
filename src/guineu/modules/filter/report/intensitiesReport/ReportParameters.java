/*
 * Copyright 2007-2008 VTT Biotechnology
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
package guineu.modules.filter.report.intensitiesReport;

import guineu.data.Parameter;
import guineu.data.ParameterType;
import guineu.data.impl.SimpleParameter;
import guineu.data.impl.SimpleParameterSet;

/**
 *
 * @author scsandra
 */
public class ReportParameters extends SimpleParameterSet {

    public static final Parameter filename = new SimpleParameter(
            ParameterType.FILE_NAME,
            "Run list file name",
            "Run list file name");
    public static final Parameter reportFilename = new SimpleParameter(
            ParameterType.FILE_NAME,
            "Save report",
            "Folder where the report will be saved.");
    public static final Parameter areaOrHeight = new SimpleParameter(
            ParameterType.BOOLEAN, "Use area ",
            "Select the check box if you want to use area instead of height", null, true, null);

    public ReportParameters() {
        super(new Parameter[]{filename, reportFilename, areaOrHeight});
    }
}