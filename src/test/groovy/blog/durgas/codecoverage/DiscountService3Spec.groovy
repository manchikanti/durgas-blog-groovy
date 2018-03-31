package blog.durgas.codecoverage

import spock.lang.Specification


class DiscountService3Spec extends Specification {
    DiscoutService3 sut

    void setup() {
        sut = new DiscoutService3()
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

    def 'Should get proper percentage for each #memberType including bronze'() {
        when:
        Double discountPercentage = sut.getDiscountPercentage(memberType)
        then:
        discountPercentage == expectedDiscountPercentage
        where:
        memberType || expectedDiscountPercentage
        'gold'     || 30
        'silver'   || 20
        'bronze'   || 10
    }
}
