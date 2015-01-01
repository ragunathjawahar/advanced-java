/*
 * Copyright 2014, Ragunath Jawahar (www.codeherenow.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codeherenow.bookstore.common;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Vector;

/**
 * This is the first attempt to create a {@link javax.swing.table.TableModel} using reflection.
 * We'll keep improving in the upcoming lectures.
 *
 * @author Ragunath Jawahar <www.codeherenow.com>
 */
public class SuperTableModel<T> extends DefaultTableModel {

    public SuperTableModel(Class<T> modelClass, List<T> pojos) {
        /*
         * Class.getFields() will return the fields that can be accessed within the current
         * access scope (depending upon where your access them reflectively). Since all fields
         * are private, we need to get `all` the fields declared by the Class.
         */
        Field[] fields = modelClass.getDeclaredFields();

        // Column names
        setColumnIdentifiers(getColumnNames(fields));

        // Add rows
        addRows(fields, pojos);
    }

    private Vector<String> getColumnNames(Field[] fields) {
        Vector<String> columnNames = new Vector<String>();
        for (Field field : fields) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            boolean annotationHasColumnName = columnAnnotation != null
                    && !"$null".equals(columnAnnotation.name());
            String columnName = annotationHasColumnName
                    ? columnAnnotation.name()
                    : toColumnName(field.getName());
            columnNames.add(columnName);
        }
        return columnNames;
    }

    /**
     * Converts camel case names to humanized strings.
     * (e.g.)
     *     1. "name" becomes "Name"
     *     2. "superPowers" becomes "Super Powers"
     *
     * @param fieldName  A camel case {@link java.lang.String}.
     * @return Humanized string.
     */
    private String toColumnName(String fieldName) {
        String humanizedString = StringUtils.join(
                StringUtils.splitByCharacterTypeCamelCase(fieldName),
                ' ');
        return WordUtils.capitalizeFully(humanizedString);
    }

    private void addRows(Field[] fields, List<T> pojos) {
        for (T pojo : pojos) {
            addRow(fields, pojo);
        }
    }

    private void addRow(Field[] fields, T pojo) {
        Vector rowData = new Vector();
        for (Field field : fields) {
            try {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                Object value = field.get(pojo);
                rowData.add(value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        addRow(rowData);
    }
}
