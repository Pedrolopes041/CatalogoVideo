package org.catalogo.domain.catalogo.category;

import org.catalogo.domain.catalogo.AggregateRoot;

import java.time.Instant;
import java.util.UUID;

public class Category extends AggregateRoot<CategoryID> {
    private String name;
    private String description;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Category(
                     final CategoryID id,
                     final String name,
                     final boolean active,
                     final Instant deletedAt,
                     final Instant updatedAt,
                     final Instant createdAt,
                     final String description) {
        super(id);
        this.name = name;
        this.active = active;
        this.deletedAt = deletedAt;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.description = description;
    }

    public static Category newCategory(final String name,
                                       final String description,
                                       final boolean active) {
        final var id = CategoryID.unique();
        final var now = Instant.now();
        return new Category(id, name, active, null, now, now, description);
    }

    public CategoryID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
