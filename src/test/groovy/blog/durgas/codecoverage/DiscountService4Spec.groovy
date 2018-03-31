package blog.durgas.codecoverage

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


class DiscountService4Spec extends Specification {
    DiscoutService4 sut

    @Shared
    Set testedMemberTypes = new TreeSet()

    void setup() {
        sut = new DiscoutService4()
    }

    @Unroll
    def 'Should get proper percentage for each #memberType'() {
        when:
        Double discountPercentage = sut.getDiscountPercentage(memberType)
        testedMemberTypes << memberType
        then:
        discountPercentage == expectedDiscountPercentage
        where:
        memberType || expectedDiscountPercentage
        'gold'     || 30
        'silver'   || 20
        'bronze'   || 10
    }

    def 'Should have tested all memberTypes'(){
        when:
        Set expectedMemberTypes = new TreeSet()
        DiscoutService4.MemberType.values().each {
            expectedMemberTypes << it.name()
        }
        then:
        testedMemberTypes == expectedMemberTypes
    }

}
