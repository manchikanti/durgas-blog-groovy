package blog.durgas.codecoverage

import spock.lang.Specification


class DiscountService2Spec extends Specification {
    DiscoutService2 sut

    void setup() {
        sut = new DiscoutService2()
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
