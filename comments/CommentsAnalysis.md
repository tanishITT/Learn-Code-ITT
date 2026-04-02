        1. Marker & TODO Comments
        // This is important!!
        
        // TODO: Fix this later
        
        2. Attribution & Journaling
           // John says we need to refund here
        
        // Added by John on 12/15/2023 - needed for the new feature
        
        3. Noise & Ambiguous Comments
           // Something went wrong
        
        // Implementation here
        
        4. Redundant Logic Descriptions
           // This method processes an order
        
        // Check if order is null
        
        // Validate the order
        
        // Check inventory
        
        // If no inventory, return failure
        
        // Reserve inventory
        
        // Process payment
        
        // Check if payment succeeded
        
        // Update inventory
        
        // Send confirmation email
        
        // Return success
        
        // Payment failed, release inventory
        
        // Return failure
        
        // Throw it
        
        // Log the error
        
        // Get the order
        
        // Refund the payment
        
        // Give back the items
        
        // Update status
        
        // Gets order by ID
        
        // Saves the order
        
        Reflection
        The initial codebase was cluttered with repetitive comments that simply mirrored the logic, adding no value since the code's intent was already self-evident. While most were removed, I retained the essential TODOs that were critical for future development. Beyond just documentation cleanup, I also restructured the logic to better align with the Single Responsibility Principle (SRP). By eliminating this "noise" and refining the code architecture, the resulting script is much more professional, legible, and easier for other developers to maintain.