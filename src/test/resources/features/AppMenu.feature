@menu
Feature: App Menu

 Scenario Outline: Verify all the menu options are linkable
    Given Hamburger menu is open
    When I click <menuOption> option
    Then Verify <menuOption> is rendered

    Examples:
     | menuOption |
#     | HOME |
#     | Latest |
#     | TECH INSIDER |
#     | Enterprise |
#     | Science |
#     | Advertising |
#     | Media |
#     | Entertainment |
#     | Transportation |
#     | FINANCE |
#     | Markets |
#     | Retail |
#     | Wealth Advisor |
#     | Your Money |
     | POLITICS |
     | Military & Defense |
     | News |
     | STRATEGY |
     | Careers |
     | Education |
     | Small Business |
     | Lists |
     | LIFE |
     | Travel |
     | SPORTS |
