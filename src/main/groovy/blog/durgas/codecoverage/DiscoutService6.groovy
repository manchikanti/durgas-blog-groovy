package blog.durgas.codecoverage

class DiscoutService6 {
    Double getDiscountPercentage(String memberTypeStr) {
        MemberType memberType = MemberType.valueOf(memberTypeStr)
        Double discountPercentage = null
        switch (memberType) {
            case MemberType.bronze:
                discountPercentage = 10
                break
            case MemberType.gold:
                discountPercentage = 30
                break
            case MemberType.silver:
                discountPercentage = 20
                break
        }
        return discountPercentage
    }

    static enum MemberType {
        bronze, gold, silver
    }
}
