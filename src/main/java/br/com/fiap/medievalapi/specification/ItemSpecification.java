package br.com.fiap.medievalapi.specification;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.medievalapi.controller.ItensController.ItensFilter;
import br.com.fiap.medievalapi.model.Item;

public class ItemSpecification {
    public static Specification<Item> withFilters(ItensFilter filter){
        return (root,query,cb)->{
            List<Predicate> predicates=new ArrayList<>();

            if(filter.name() !=null && !filter.name().isBlank()){
                predicates.add(cb.like(cb.lower(root.get("name")),"%" +filter.name().toLowerCase()+"%"));
            }
            if(filter.type()!=null){
                predicates.add(cb.equal(root.get("type"),filter.type()));
            }

            if (filter.minPrice() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("prize"), filter.minPrice()));
            }

            if (filter.maxPrice() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("prize"), filter.maxPrice()));
            }
            if(filter.rarity()!=null){
                predicates.add(cb.equal(root.get("rarity"),filter.rarity()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    
}
