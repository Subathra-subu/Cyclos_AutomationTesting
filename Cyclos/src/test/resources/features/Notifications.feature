@Akksheetha @Notifications

Feature: Akksheetha_2026-05-29_Error_Slayers_Notifications.feature

Description:
  Validate Notification functionality in cyclos.
  
Background:
Given Registered user launches the Cyclos application


@NotificationsNavigation
Scenario: Verify user can navigate to Notifications page

    When User clicks on the Notifications icon
    Then Notifications page should be displayed
    
@UnreadNotifications
Scenario: Verify user can view all notifications

  And  User is on the Notifications page
  When User unchecks the Unread Only checkbox
  Then All notifications should be displayed
  
@OpenNotification
Scenario: Verify user can open a notification

    When User clicks on a notification
    Then Notification should be opened