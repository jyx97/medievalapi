package br.com.fiap.medievalapi.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.medievalapi.model.Personagem;
import jakarta.persistence.criteria.Predicate;

public class PersonagemSpecification {

    public static Specification<Personagem> comFiltros(String name, String typeClass) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }

            if (typeClass != null && !typeClass.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("typeClass")), "%" + typeClass.toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
