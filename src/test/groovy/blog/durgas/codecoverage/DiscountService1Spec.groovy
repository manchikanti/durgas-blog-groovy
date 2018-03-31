package blog.durgas.codecoverage

import spock.lang.Specification


class DiscountService1Spec extends Specification {
    DiscoutService1 sut

    void setup() {
        sut = new DiscoutService1()
    }

    def 'Should get discount percentage for #memberType'() {
        when:
        Double discountPercentage = sut.getDiscountPercentage(memberType)
        then:
        discountPercentage
        where:
        memberType << ['gold', 'silver']
    }

    def 'Should get proper percentage for each #memberType'() {
        when:
        Double discountPercentage = sut.getDiscountPercentage(memberType)
        then:
        discountPercentage == expectedDiscountPercentage
        where:
        memberType || expectedDiscountPercentage
        'gold'     || 30
        'silver'   || 20
    }
}
