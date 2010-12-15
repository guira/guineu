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
package guineu.data.parser.impl.database;

import guineu.data.parser.Parser;
import guineu.data.Dataset;
import guineu.data.impl.datasets.SimpleLCMSDataset;
import guineu.database.retrieve.impl.OracleRetrievement;
import guineu.database.retrieve.DataBase;

/**
 *
 * @author scsandra
 */
public class LCMSParserDataBase implements Parser {

        private DataBase db;
        private SimpleLCMSDataset dataset;
        private String datasetName;

        public LCMSParserDataBase(Dataset dataset) {
                db = new OracleRetrievement();
                this.dataset = (SimpleLCMSDataset) dataset;
        }

        public void fillData() {
                db.getLCMSRows(dataset);
        }

        public String getDatasetName() {
                return datasetName;
        }

        public float getProgress() {
                return db.getProgress();
        }

        public Dataset getDataset() {
                return this.dataset;
        } 
}