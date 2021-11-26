package com.my.db.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable {

        private static final long serialVersionUID = 5456277830808334232L;

        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

    }